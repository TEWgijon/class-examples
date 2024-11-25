package es.uniovi.tew.service.template;

public interface Command<T> {
    T execute();
}
