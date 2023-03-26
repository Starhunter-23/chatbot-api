# 基础镜像
FROM openjdk:8-jre-slim
# 作者
MAINTAINER Magi
# 配置
ENV PARAMS="--chatbot-api.openAiKey=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 --chatbot-api.groupId=28885881241141"

ENV LANG=zh_CN.GBK

# 时区
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 添加应用
ADD /chatbot-api-interfaces/target/chatbot-api.jar /chatbot-api.jar
# 执行镜像；docker run -e PARAMS=" --chatbot-api.groupId=28885881241141 --chatbot-api.openAiKey=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 --chatbot-api.cookie=zsxq_access_token=F4184D71-62C4-6D99-7364-9C45082369EE_11DE56A3CE03D224; abtest_env=product; zsxqsessionid=f520d1ed4466200c2f035cd8f2e192f7" -p 8090:8090 --name chatbot-api -d chatbot-api:1.0
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /chatbot-api.jar $PARAMS"]