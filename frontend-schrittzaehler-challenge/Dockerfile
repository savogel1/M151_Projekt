#FROM node:14.17.0-alpine
#WORKDIR /app
#COPY package.json .
#RUN npm install
#COPY . .
#EXPOSE 80
#CMD npm run start

# Build
FROM node:alpine AS build
WORKDIR /app
COPY . .
RUN npm i && npm run build

# Run
FROM nginx:alpine
COPY --from=build /app/dist/frontend-schrittzaehler-challenge /usr/share/nginx/html
EXPOSE 80