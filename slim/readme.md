### Installation

Terminal

```bash
composer install
```

### Setup

Terminal

```bash
composer dump-autoload
```

### Environment File

.env

```
DEBUG=true
```

### Development Server

Terminal

```bash
composer run-script serv
```

### Endpoint & URI

```
http://localhost:8000/api/item

GET /api/item
POST /api/item

GET /api/item/{id}
PUT /api/item/{id}
DELETE /api/item/{id}
```

### PHPUnitTest

Terminal

```bash
composer run-script test
```
