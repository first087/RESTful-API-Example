<?php

namespace App\Controllers;

use App\Stores\ItemStore;

class ItemController extends BaseController
{
    private $store;

    public function __construct() {
        $this->store = new ItemStore();
    }

    public function index($req, $res)
    {
        return $res
            ->withStatus(200)
            ->write(json_encode($this->store->all()));
    }

    public function show($req, $res, $args)
    {
        $index = $args['id'];

        if (is_null($this->store->one($index))) {
            return $res->withStatus(404);
        }

        return $res
            ->withStatus(200)
            ->write(json_encode($this->store->one($index)));
    }

    public function store($req, $res)
    {
        $item = $req->getParsedBody()['item'];

        if (!is_string($item['item'])) {
            return $res->withStatus(400);
        }

        try {
            $this->store->insert($item);

            return $res->withStatus(201);

        } catch (Exception $e) {
            return $res->withStatus(400);
        }
    }

    public function update($req, $res, $args)
    {
        $index = $args['id'];
        $oldItem = $this->store->one($index);

        $item = $req->getParsedBody()['item'];

        if (is_null($oldItem)) {
            return $res->withStatus(404);
        }

        if (!is_string($item['item'])) {
            return $res->withStatus(400);
        }

        try {
            $this->store->update($index, $item);

            return $res
                ->withStatus(200)
                ->write(json_encode(compact('oldItem')));

        } catch (Exception $e) {
            return $res->withStatus(400);
        }
    }

    public function destroy($req, $res, $args)
    {
        $index = $args['id'];
        $removeItem = $this->store->one($index);

        if (is_null($removeItem)) {
            return $res->withStatus(404);
        }

        try {
            $this->store->delete($index);

            return $res
                ->withStatus(200)
                ->write(json_encode(compact('removeItem')));

        } catch (Exception $e) {
            return $res->withStatus(400);
        }
    }
}
