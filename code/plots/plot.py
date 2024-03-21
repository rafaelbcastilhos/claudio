import matplotlib.pyplot as plt
import uuid

def method_size(categories, values, size, ylabel):
    plt.bar(categories, values, color='gray')
    plt.gca().spines['top'].set_visible(False)
    plt.gca().spines['right'].set_visible(False)

    plt.gca().tick_params(axis='x', colors='k')
    plt.gca().tick_params(axis='y', colors='k') 

    # Adicionando rótulos e título
    plt.xlabel('Formato dos dados')
    plt.ylabel(ylabel)
    plt.title(f'Gráfico de Barras para tamanho {size}')

    for i, v in enumerate(values):
        plt.text(i, v + 0.1, "{:.2f}".format(v), ha='center', va='bottom')

    plt.savefig(f'./images/method_size_{uuid.uuid4()}.png', dpi=300)
    plt.clf()


def method_service(categories, values, service, ylabel):
    print(categories)
    print(values)
    plt.bar(categories, values, color='gray')
    plt.gca().spines['top'].set_visible(False)
    plt.gca().spines['right'].set_visible(False)

    plt.gca().tick_params(axis='x', colors='k')
    plt.gca().tick_params(axis='y', colors='k')

    # Adicionando rótulos e título

    plt.xlabel('Formato dos dados')
    plt.ylabel(ylabel)
    plt.title(f'Gráfico de Barras para o serviço {service}')

    for i, v in enumerate(values):
        plt.text(i, v + 0.1, "{:.2f}".format(v), ha='center', va='bottom')

    plt.savefig(f'./images/method_service_{uuid.uuid4()}.png', dpi=300)
    plt.clf()


def method_type(categories, values, typeData, ylabel):
    plt.bar(categories, values, color='gray')
    plt.gca().spines['top'].set_visible(False)
    plt.gca().spines['right'].set_visible(False)

    plt.gca().tick_params(axis='x', colors='k')
    plt.gca().tick_params(axis='y', colors='k')

    # Adicionando rótulos e título
    plt.xlabel('Formato dos dados')
    plt.ylabel(ylabel)
    plt.title(f'Gráfico de Barras para a formatação do tipo {typeData}')

    for i, v in enumerate(values):
        plt.text(i, v + 0.1, "{:.2f}".format(v), ha='center', va='bottom')

    plt.savefig(f'./images/method_type_{uuid.uuid4()}.png', dpi=300)
    plt.clf()
