const assert = require('chai').assert
const store = require('../store')

describe('Test item store', () => {
  beforeEach(() => store.init())

  it('Get all items', () => {
    const items = store.getAllItems()

    assert.isArray(items)
    assert.lengthOf(items, 1)
  })

  it('Get item', () => {
    const item = store.getItem(0)

    assert.isString(item)
  })

  it('Add item', () => {
    const newItem1 = 'New item 1'
    const newItem2 = 'New item 2'

    store.addItem(newItem1)
    store.addItem(newItem2)

    const items = store.getAllItems()

    assert.lengthOf(items, 3)
    assert.strictEqual(items[1], newItem1)
    assert.strictEqual(items[2], newItem2)
  })
})
