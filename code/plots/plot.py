import matplotlib.pyplot as plt

def method_size(categories, values, size):
    plt.bar(categories, values, color='blue')

    # Adicionando rótulos e título
    plt.xlabel('Formato dos dados')
    plt.ylabel('Tempo médio da requisição (ms)')
    plt.title(f'Gráfico de Barras para tamanho {size}')

    for i, v in enumerate(values):
        plt.text(i, v + 0.1, "{:.2f}".format(v), ha='center', va='bottom')

    # Exibindo o gráfico
    plt.show()
