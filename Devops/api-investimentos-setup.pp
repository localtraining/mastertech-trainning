$svc_conf_template = @(END)
[Unit] 
Description=Eureka Server

[Service]
User=root

ExecStart=/usr/bin/java -Xms100m -Xmx512m -jar /home/ubuntu/apps/investimentos.jar
SuccessExitStatus=143
TimeoutStopSec=10
Restart=on-failure
RestartSec=5
END

class { 'java':
  package => 'openjdk-8-jdk',
}
file { '/etc/systemd/system/api-investimentos.service':
  ensure => file,
  content => inline_epp($svc_conf_template),
}

ssh_authorized_key { 'jefferson brito@Y530-Jefferson':
  ensure => present,
  user   => 'ubuntu',
  type   => 'ssh-rsa',
  key    => 'AAAAB3NzaC1yc2EAAAADAQABAAABAQCpzS2+M3xsSqGDf4Pne0gv9YkkECldeI/zCkXHACTbvgptS2HuSJvbBefQq/uQB1fl9Aw+oDhlhW5j2eJqCb3Jzpi763RQIb+eT3eqXwTzuO0X/Y04MPwocyWf+skJ/T9tBHijZRZNZjnq/yAJ0Rnz3YcWpL3vDvVMYUqAq2eJH4HrSJDiEmKEsmUV5GoODPfBItwbsuY+D2pe9J/CxGRCJfhf1pYPzVmUd7j/0VgWdFx/TbBnHulZl9i2YUkuX02xN5GqJkenBQCqgjhZKxgqURe1cqtmdxWfsuuwPB5VTlH9OZfuGGUFGFuVLXt+YIMzbSsmfsv/qadtpkRxQVmd'
}

ssh_authorized_key { 'jenkins@banana':
  ensure => present,
  user   => 'ubuntu',
  type   => 'ssh-rsa',
  key    => 'AAAAB3NzaC1yc2EAAAADAQABAAABAQDvNfe5q8SfXeGyl6cB2vR4mo7pHq30sjPgMrhP05UF2gH3bgz7dGREpb6caCGJo8gpQXofeEI0wdqLw0KbmIuqSMpT4yQQHWr6VqWbDaK2XQutHJkElGQMTCBADwT4bGt8b2eNV8s581g/RS01q4L7F9iSkMzSms3BM63FkZHZAOlOTHmRnN3Ju39MolmjGPwb6SpUFYpMIZLic1vKTe4p1L3PQL4czIJxpssE283iOeRiAceD/Xaly4mgVqdxmMEm3gZo5PzcPMu5Y08M6Ur0vJR5i4IVSSheBhzcKLshuvTBt5bobYtG1BWatQIpbKoCO6Uqnf/7U7FvPHJTYsJb'
}

service { 'api-investimentos':
  ensure => running,
}
class{"nginx": }
nginx::resource::server { 'api-investimentos-app':
  server_name => ['_'],
  listen_port => 80,
  proxy => 'http://localhost:8080',
}
file { "/etc/nginx/conf.d/default.conf":
  ensure => absent,
  notify => Service['nginx'],
}
