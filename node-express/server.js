const express = require('express')

const store = require('./store')

store.init()

const app = express()

app
  .use(express.json())
  .get('/item/', (req, res) => {
    res.send({ items: store.getAllItems() })
  })
  .get('/item/:index', (req, res) => {
    const item = store.getItem(Number(req.params.index))

    if (item === undefined) {
      res.status(404).end()
      return
    }

    res.send({ item })
  })
  .post('/item/', (req, res) => {
    if (typeof req.body.item !== 'string') {
      res.status(400).end()
      return
    }

    store.addItem(req.body.item)

    res.status(201).end()
  })
  .put('/item/:index', (req, res) => {
    if (store.getItem(Number(req.params.index)) === undefined) {
      res.status(404).end()
      return
    }

    if (typeof req.body.item !== 'string') {
      res.status(400).end()
      return
    }

    const oldItem = store.updateItem(Number(req.params.index), req.body.item)

    res.send({ oldItem })
  })
  .delete('/item/:index', (req, res) => {
    if (store.getItem(Number(req.params.index)) === undefined) {
      res.status(404).end()
      return
    }

    const removeItem = store.removeItem(Number(req.params.index))

    res.send({ removeItem })
  })
  .listen(3000, () => {
    console.log('Example app listening on port 3000!')
  })
