FROM node:14-alpine
LABEL maintainer="Artit Kiuwilai <first087@gmail.com>"

EXPOSE 3000
WORKDIR /app
COPY . /app

RUN npm install --production

USER node

CMD ["npm", "start"]
