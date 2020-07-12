<?php

require __DIR__ . join(DIRECTORY_SEPARATOR, [ '', '..', 'vendor', 'autoload.php' ]);

use Dotenv\Dotenv;
use Slim\App;
use Slim\Container;
use App\Middlewares\ApiMiddleware;

$env = new Dotenv(__DIR__ . join(DIRECTORY_SEPARATOR, [ '', '..' ]));
$env->load();

$configuration = [
    'settings' => [
        'displayErrorDetails' => getenv('DEBUG'),
    ],
];

$app = new App(new Container($configuration));
$apiMiddleware = new ApiMiddleware;

$app->get('/', function ($req, $res) {
    return $res->write('<h3>API Endpoint</h3><pre><code>/api/item</h3></code></pre>');
});

$app->group('/api', function() {
    $this->group('/item', function() {
        $this->get('', 'App\Controllers\ItemController:index');
        $this->post('', 'App\Controllers\ItemController:store');

        $this->get('/{id}', 'App\Controllers\ItemController:show');
        $this->put('/{id}', 'App\Controllers\ItemController:update');
        $this->delete('/{id}', 'App\Controllers\ItemController:destroy');
    });
})->add($apiMiddleware);

$app->run();
