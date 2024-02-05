import matplotlib.pyplot as plt

def method_size(categories, values, size, ylabel):
    plt.bar(categories, values)

    # Adicionando rótulos e título
    plt.xlabel('Formato dos dados')
    plt.ylabel(ylabel)
    plt.title(f'Gráfico de Barras para tamanho {size}')

    for i, v in enumerate(values):
        plt.text(i, v + 0.1, "{:.2f}".format(v), ha='center', va='bottom')

    plt.show()

def method_service(categories, values, service, ylabel):
    plt.bar(categories, values)

    # Adicionando rótulos e título

    plt.xlabel('Formato dos dados')
    plt.ylabel(ylabel)
    plt.title(f'Gráfico de Barras para o serviço {service}')

    for i, v in enumerate(values):
        plt.text(i, v + 0.1, "{:.2f}".format(v), ha='center', va='bottom')

    plt.tight_layout()  # Evita que os elementos se sobreponham
    plt.savefig(f'./images/method_service-{service}.png', dpi=300, bbox_inches='tight')

    plt.show()

def method_type(categories, values, typeData, ylabel):
    plt.bar(categories, values)

    # Adicionando rótulos e título
    plt.xlabel('Formato dos dados')
    plt.ylabel(ylabel)
    plt.title(f'Gráfico de Barras para a formatação do tipo {typeData}')

    for i, v in enumerate(values):
        plt.text(i, v + 0.1, "{:.2f}".format(v), ha='center', va='bottom')

    plt.show()