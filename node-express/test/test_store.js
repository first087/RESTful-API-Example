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
})
