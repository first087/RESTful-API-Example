FROM python:3.6-slim
LABEL maintainer="VatNan <vattnana.bu@gmail.com>"

ENV PYTHONUNBUFFERED 1
RUN mkdir /code
WORKDIR /code
ADD requirements.txt /code/
RUN pip install -r requirements.txt
ADD . /code/
EXPOSE 8000

CMD ["python3", "manage.py", "runserver", "0.0.0.0:8000"]