#### STEP 1: 通过Docker启动并初始化Ubuntu
- ubuntu:18.04
- 安装软件包
```
apt-get -y update
apt-get -y install ssh
apt-get -y install net-tools
apt-get -y install rsync 
```
- 允许root远程登陆
```
vim /etc/ssh/sshd_config
PermitRootLogin yes
PasswordAuthentication yes
service ssh start // docker模式下，每次启动容器都需要手工启动？
```

#### STEP 2：安装JDK
```shell script
cat /etc/profile
export JAVA_HOME=/usr/local/jdk
export HADOOP_HOME=/usr/local/hadoop
export HIVE_HOME=/usr/local/hive
export PATH=$JAVA_HOME/bin:$HADOOP_HOME/bin:$HIVE_HOME/bin:$PATH
```

#### STEP 3：安装并启动Hadoop
```
https://hadoop.apache.org/docs/r2.10.2/hadoop-project-dist/hadoop-common/SingleCluster.html
vim etc/hadoop/hadoop-env.sh
export JAVA_HOME=/usr/local/jdk
sbin/start-dfs.sh
```

#### STEP 4: 安装并启动HIVE
```
https://cwiki.apache.org/confluence/display/Hive/GettingStarted
schematool -dbType derby -initSchema // 应该是初始化元数据数据库
```