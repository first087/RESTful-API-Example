const Hapi = require('@hapi/hapi')

const store = require('./store')

store.init()

const init = async () => {
  const server = new Hapi.Server({
    port: 3000,
  })

  server.route({
    method: 'GET',
    path: '/item/',
    handler: () => ({ items: store.getAllItems() }),
  })

  server.route({
    method: 'GET',
    path: '/item/{index}',
    handler: (request, h) => {
      const item = store.getItem(Number(request.params.index))

      if (item === undefined) return h.response().code(404)

      return { item }
    },
  })

  server.route({
    method: 'POST',
    path: '/item/',
    handler: (request, h) => {
      if (typeof request.payload.item !== 'string') return h.response().code(400)

      store.addItem(request.payload.item)

      return h.response().code(201)
    },
  })

  server.route({
    method: 'PUT',
    path: '/item/{index}',
    handler: (request, h) => {
      if (store.getItem(Number(request.params.index)) === undefined) return h.response().code(404)

      if (typeof request.payload.item !== 'string') return h.response().code(400)

      const oldItem = store.updateItem(Number(request.params.index), request.payload.item)

      return { oldItem }
    },
  })

  server.route({
    method: 'DELETE',
    path: '/item/{index}',
    handler: (request, h) => {
      if (store.getItem(Number(request.params.index)) === undefined) return h.response().code(404)

      const removeItem = store.removeItem(Number(request.params.index))

      return { removeItem }
    },
  })

  await server.start()
  // eslint-disable-next-line no-console
  console.log('Server running on %s', server.info.uri)
}

process.on('unhandledRejection', (err) => {
  // eslint-disable-next-line no-console
  console.log(err)
  process.exit(1)
})

init()
