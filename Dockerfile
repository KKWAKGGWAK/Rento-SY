FROM bellsoft/liberica-openjdk-alpine:17

ENV SPRING_PROFILES_ACTIVE=deploy

# 로그 디렉토리 생성 및 권한 설정
RUN mkdir -p /logs && chmod 755 /logs

COPY build/libs/Rento-0.0.1-SNAPSHOT.jar app.jar

# OpenTelemetry Java Agent 다운로드
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

EXPOSE 8080

# 기존 설정 그대로 유지
ENTRYPOINT ["java", "-javaagent:/opentelemetry-javaagent.jar", \
            "-Dotel.service.name=rento-service", \
            "-Dmanagement.tracing.sampling.probability=1.0", \
            "-Dotel.exporter.otlp.endpoint=http://tempo:4317", \
            "-jar", "app.jar"]