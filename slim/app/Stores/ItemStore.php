<?php

namespace App\Stores;

class ItemStore implements Store
{
    private $items;

    public function __construct()
    {
        $this->items = [
            'foo'
        ];
    }

    public function all()
    {
        return $this->items;
    }

    public function one($index)
    {
        return $this->items[$index];
    }

    public function insert($item)
    {
        array_push($this->items, $item);
    }

    public function update($index, $item)
    {
        $this->items[$index] = $item;
    }

    public function delete($index)
    {
        unset($this->items[$index]);
    }
}
