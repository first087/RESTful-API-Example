<?php

namespace App\Stores;

interface Store
{
    public function all();

    public function one($index);

    public function insert($item);

    public function update($index, $item);

    public function delete($index);
}
