package br.com.catolicapb.constants;

public class CustomerConstants {

    private CustomerConstants() { }

    public static final String CODE_STATUS_404 = "404";
    public static final Integer CODE_STATUS_201 = 201;
    public static final Integer CODE_STATUS_200 = 200;

    public static final String CUSTOMER_MESSAGE_PET_EXISTS_400 = "Pet já cadastrado para o cliente";
    public static final String CUSTOMER_MESSAGE_CREATED_201 = "Cliente salvo com sucesso!";
    public static final String CUSTOMER_MESSAGE_UPDATED_200 = "Cliente atualizado com sucesso!";
    public static final String CUSTOMER_MESSAGE_NOT_FOUND_404 = "Cliente não encontrado com o CPF informado";
    public static final String CUSTOMER_MESSAGE_DEACTIVATED_200 = "Cliente desativado com sucesso!";
    public static final String CUSTOMER_MESSAGE_ACTIVATED_200 = "Cliente ativado com sucesso!";
}
