# 1) 빌드 단계
FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

# 2) 정적 파일 서빙 단계
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html