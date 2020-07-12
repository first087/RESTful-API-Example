const express = require('express')

const store = require('./store')

store.init()

const getAllItems = (req, res) => {
  res.send({ items: store.getAllItems() })
}

const getItem = (req, res) => {
  const item = store.getItem(Number(req.params.index))

  if (item === undefined) {
    res.status(404).end()
    return
  }

  res.send({ item })
}

const addItem = (req, res) => {
  if (typeof req.body.item !== 'string') {
    res.status(400).end()
    return
  }

  store.addItem(req.body.item)

  res.status(201).end()
}

const updateItem = (req, res) => {
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
}

const deleteItem = (req, res) => {
  if (store.getItem(Number(req.params.index)) === undefined) {
    res.status(404).end()
    return
  }

  const removeItem = store.removeItem(Number(req.params.index))

  res.send({ removeItem })
}

const app = express()

app
  .use(express.json())
  .get('/item/', getAllItems)
  .get('/item/:index', getItem)
  .post('/item/', addItem)
  .put('/item/:index', updateItem)
  .delete('/item/:index', deleteItem)
  // eslint-disable-next-line no-console
  .listen(3000, () => console.log('Example app listening on port 3000!'))
