const express = require('express')
const bodyParser = require('body-parser')

const store = require('./store')

const app = express()
app.use(bodyParser.json())

store.init()

app.get('/item/', (req, res) => {
  res.send({ items: store.getAllItems() })
})

app.get('/item/:index', (req, res) => {
  const item = store.getItem(req.params.index);

  if (item === undefined) {
    res.status(404).end()
    return
  }

  res.send({ item })
})

app.post('/item/', (req, res) => {
  store.addItem(req.body.item)

  res.status(201).end()
})

app.listen(3000, () => {
  console.log('Example app listening on port 3000!')
})
