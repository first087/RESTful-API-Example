<?php

namespace App\Middlewares;

class ApiMiddleware
{
    public function __invoke($req, $res, $next)
    {
        $res = $next($req, $res);

        return $res
            ->withHeader('Content-Type', 'application/json');;
    }
}
