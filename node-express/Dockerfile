FROM node:8.4.0-alpine
LABEL maintainer="Artit Kiuwilai <first087@gmail.com>"

COPY . /usr/src/app
WORKDIR /usr/src/app
EXPOSE 3000

RUN npm install --production

USER node

CMD ["node", "server.js"]
