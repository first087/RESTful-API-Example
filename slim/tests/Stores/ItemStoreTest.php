<?php

use PHPUnit\Framework\TestCase;

use App\Stores\ItemStore;

class ItemStoreTest extends TestCase
{
    public function testCreate()
    {
        $store = new ItemStore();

        $this->assertEquals(1, count($store->all()));
        $this->assertEquals('foo', $store->one(0));
    }

    public function testInsert()
    {
        $store = new ItemStore();

        $store->insert('bar');
        $store->insert('baz');
        $this->assertEquals(3, count($store->all()));
    }

    public function testUpdate()
    {
        $store = new ItemStore();

        $store->update(0, 'bar');
        $this->assertEquals(1, count($store->all()));
        $this->assertEquals('bar', $store->one(0));
    }

    public function testDelete()
    {
        $store = new ItemStore();

        $store->delete(0);
        $this->assertEquals(0, count($store->all()));
    }
}
