package br.com.estudos.builder;

import org.jetbrains.annotations.NotNull;

public class User {

    //todos os atributos são finais
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String address;


    private User(@NotNull UserBuilder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //criamos apenas os gets porque
    //apenas o necessário

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    //criamos a classe estática dentro da outra
    public static class UserBuilder{

        //o que for final, vai ter que ser colocado no construtor e tornasse
        //'obrigatório' ao crirar o usuário via builder.
        private final String firstName;
        private final String lastName;
        private int age;
        private String address;
        private String phone;

        public UserBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age){
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone){
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address){
            this.address = address;
            return this;
        }

        //retorna o objeto construido ao chamado o método build
        public User build() {
            User user = new User(this);
            validateUser(user);
            return user;
        }

        private void validateUser(User user){
            try{
                if (user.getAge() < 18) {
                    //joga uma exceção na pilha alertando que o usuário não tem ai dade minima
                    //como a criação do usuário esta 'hardcoded' fica apenas como aviso
                    throw new CriacaoUsuarioInvalidaException("Idade do usuário inferior a permitida");
                }
            }catch (CriacaoUsuarioInvalidaException e){
                e.printStackTrace();
            }

        }

    }
}
