const Hapi = require('hapi')
const store = require('./store')

const server = new Hapi.Server()

store.init()

server.connection({
  port: 3000,
})

server.route({
  method: 'GET',
  path: '/item/',
  handler: (request, reply) => reply({ items: store.getAllItems() }),
})

server.start((err) => {
  if (err) {
    throw err
  }

  console.log('Server running at:', server.info.uri);
})
