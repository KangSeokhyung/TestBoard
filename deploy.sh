#!/bin/bash

# 변수 설정
PROJECT_NAME="TestBoard"
JAR_PATH="./build/libs/*.jar"
DEPLOY_PATH="/home/ec2-user/app"
DEPLOY_LOG_PATH="/home/ec2-user/app/deploy.log"
DEPLOY_ERR_LOG_PATH="/home/ec2-user/app/deploy_err.log"
APPLICATION_LOG_PATH="/home/ec2-user/app/application.log"

# 현재 실행 중인 애플리케이션 PID 확인
CURRENT_PID=$(pgrep -f $PROJECT_NAME)

# 기존 애플리케이션 종료
if [ -z $CURRENT_PID ]; then
    echo "현재 실행중인 애플리케이션이 없습니다"
else
    echo "실행중인 $CURRENT_PID 애플리케이션 종료"
    kill -15 $CURRENT_PID
    sleep 5
fi

# JAR 파일 복사
echo "새 애플리케이션 배포"
cp $JAR_PATH $DEPLOY_PATH/

# JAR 파일 실행
echo "새 애플리케이션 실행"
nohup java -jar $DEPLOY_PATH/*.jar > $APPLICATION_LOG_PATH 2> $DEPLOY_ERR_LOG_PATH &

echo "배포 완료"
