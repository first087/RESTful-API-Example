let items = []

module.exports = {
  init: () => {
    items = ['Init item']
  },
  getAllItems: () => items,
  getItem: (index) => items[index],
  addItem: (newItem) => items.push(newItem),
  updateItem: (index, updateItem) => {
    const oldItem = items[index]
    items[index] = updateItem
    return oldItem
  },
  removeItem: (index) => items.splice(index, 1)[0],
}
