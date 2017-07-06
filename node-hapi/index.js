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

server.route({
  method: 'GET',
  path: '/item/{index}',
  handler: (request, reply) => {
    const item = store.getItem(Number(request.params.index))

    if (item === undefined) return reply().code(404)

    return reply({ item })
  },
})

server.start((err) => {
  if (err) {
    throw err
  }

  console.log('Server running at:', server.info.uri);
})
