let items = []

module.exports = {
  init: () => {
    items = ['Init item']
  },
  getAllItems: () => items,
  getItem: index => items[index],
  addItem: newItem => items.push(newItem),
}
