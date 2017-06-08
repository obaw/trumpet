#!/usr/bin/expect -f
set timeout 10
spawn ssh root@helloxw.com
expect "*yes/no" {send "yes\r";exp_continue}
send "cd /opt\r"
send "ps_pid=\$(ps -ef|grep trumpet.jar|grep -v grep|awk '{print \$2}')\r"
send "kill \$ps_pid\r"
send "rm trumpet.log\r"
send "nohup java -jar trumpet.jar >trumpet.log &\r"
send "exit\r"
expect eof