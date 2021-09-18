package br.com.estudos.builder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Comparator;

public class BuilderMain {



    @SuppressWarnings("all") //só para remover os erros de 'boas praticas' de code da IDE>
    public static void main(String[] args) throws CriacaoUsuarioInvalidaException {

        //aqui é possível chamar os métodos para criar o objeto de modo mais dinamico
        User user1 = new User.UserBuilder("Fabio", "Sousa")
                .age(30)
                .phone("9999999")
                .address("Rua Dos Bobos")
                .build();

        //a criaçao do usuário exige apenas o que esta dentro dos parenteses
        //o resto sendo opcional, faciltiando muito a construção do objeto de forma dinamica
        User user2 = new User.UserBuilder("André", "Marcos")
                .age(30)
                .build();

        //exemplo com apenas os campos obrigatórios
        User user3 = new User.UserBuilder("Maria", "Silva").build();


        ArrayList<User> listaUsuarios = new ArrayList<>();

        //adiciona os usuários na lista
        listaUsuarios.add(user1);
        listaUsuarios.add(user2);
        listaUsuarios.add(user3);

        //organiza os usuários pelo prieiro nome de forma lexicografica
        listaUsuarios.sort(Comparator.comparing(User::getFirstName));

        //usa um foreach com uma expressão lambda para iterar a lista e imprimir o toString()
        listaUsuarios.forEach((n)-> System.out.println(n));

        //outra forma mais 'elegante' de fazer seria assim:
        listaUsuarios.forEach(System.out::println);


    }

}
