from django.http import JsonResponse, HttpResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework.parsers import JSONParser
from rest_framework.decorators import parser_classes
from .store import Store

# Create your views here.


@csrf_exempt
@parser_classes((JSONParser))
def item_list(request):
    """
    List all code items, or create a new item.
    """
    # check method
    if request.method == 'GET':
        return JsonResponse({'items': Store.get_all_items()}, safe=False)

    elif request.method == 'POST':
        body = JSONParser().parse(request)
        Store.add_item(body['item'])
        return HttpResponse(status=201)


@csrf_exempt
@parser_classes((JSONParser))
def item_detail(request, index):
    """
    Retrieve, update or delete a item.
    """
    # validate request
    item = Store.get_item(index)
    if item == None:
        return HttpResponse(status=404)

    # check method
    if request.method == 'GET':
        return JsonResponse({'item': item})

    elif request.method == 'PUT':
        body = JSONParser().parse(request)
        # validate request
        if not isinstance(body['item'], str):
            return HttpResponse(status=400)
        # update item
        old_item = Store.update_item(index, body['item'])
        return JsonResponse({'oldItem': old_item})

    elif request.method == 'DELETE':
        body = JSONParser().parse(request)
        # remove item
        remove_item = Store.remove_item(index)
        return JsonResponse({'removeItem': remove_item})
