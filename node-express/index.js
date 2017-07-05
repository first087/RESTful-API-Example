const express = require('express')

const store = require('./store')

const app = express()

store.init()

app.get('/item/', (req, res) => {
  res.send({ items: store.getAllItems() })
})

app.listen(3000, () => {
  console.log('Example app listening on port 3000!')
})
