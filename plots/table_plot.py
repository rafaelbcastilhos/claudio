import matplotlib.pyplot as plt
import matplotlib.cm as cm


def serialization_deserialization_time():
    sizes = ['Pequeno', 'Médio', 'Grande']
    XML=[4.47, 4.80, 19.01]
    JSON=[1.14, 1.96, 16.55]
    MSGPACK=[1.36, 3.21, 25.69]
    KRYO=[139.16, 139.43, 142.02]

    bar_width = 0.2
    index = range(len(sizes))

    plt.bar(index, XML, bar_width, color='0.1', label='XML') 
    plt.bar([i + bar_width for i in index], JSON, bar_width, color='0.3', label='JSON') 
    plt.bar([i + 2 * bar_width for i in index], MSGPACK, bar_width, color='0.6', label='MSGPACK') 
    plt.bar([i + 3 * bar_width for i in index], KRYO, bar_width, color='0.8', label='KRYO') 

    plt.gca().spines['top'].set_visible(False)
    plt.gca().spines['right'].set_visible(False)

    plt.gca().tick_params(axis='x', colors='k')
    plt.gca().tick_params(axis='y', colors='k')

    plt.xlabel('Tamanho')
    plt.ylabel('Tempo de médio de serialização e desserialização (ms)')
    plt.xticks([i + 1.5 * bar_width for i in index], sizes)
    plt.legend(loc='upper left')

    plt.savefig(f'./images/serialization_deserialization_time.png', dpi=300)
    plt.clf()

def bytes_size_services():
    services = ['EC2', 'ECS', 'LAMBDA']

    XML=[168133.19, 168111.49, 168120.97]
    JSON=[122535.72, 122720.51, 122705.33]
    MSGPACK=[105191.36, 105187.53, 105197.81]
    KRYO=[5691.19, 5690.98, 5691.03]

    bar_width = 0.2
    index = range(len(services))

    plt.bar(index, XML, bar_width, color='0.1', label='XML') 
    plt.bar([i + bar_width for i in index], JSON, bar_width, color='0.3', label='JSON') 
    plt.bar([i + 2 * bar_width for i in index], MSGPACK, bar_width, color='0.6', label='MSGPACK') 
    plt.bar([i + 3 * bar_width for i in index], KRYO, bar_width, color='0.8', label='KRYO') 

    plt.gca().spines['top'].set_visible(False)
    plt.gca().spines['right'].set_visible(False)

    plt.gca().tick_params(axis='x', colors='k')
    plt.gca().tick_params(axis='y', colors='k')

    plt.xlabel('Serviço')
    plt.ylabel('Quantidade de bytes serializados')
    plt.xticks([i + 1.5 * bar_width for i in index], services)
    plt.legend(loc='upper right')

    plt.savefig(f'./images/bytes_size_services.png', dpi=300)
    plt.clf()

def request_time_services():
    services = ['EC2', 'ECS', 'LAMBDA']

    XML=[412.94, 418.02, 494.15]
    JSON=[387.60, 389.40, 489.56]
    MSGPACK=[367.62, 365.95, 483.56]
    KRYO=[332.14, 319.76, 435.04]

    bar_width = 0.2
    index = range(len(services))

    plt.bar(index, XML, bar_width, color='0.1', label='XML') 
    plt.bar([i + bar_width for i in index], JSON, bar_width, color='0.3', label='JSON') 
    plt.bar([i + 2 * bar_width for i in index], MSGPACK, bar_width, color='0.6', label='MSGPACK') 
    plt.bar([i + 3 * bar_width for i in index], KRYO, bar_width, color='0.8', label='KRYO') 

    plt.gca().spines['top'].set_visible(False)
    plt.gca().spines['right'].set_visible(False)

    plt.gca().tick_params(axis='x', colors='k')
    plt.gca().tick_params(axis='y', colors='k')

    plt.xlabel('Serviço')
    plt.ylabel('Tempo médio total da requisição (ms)')
    plt.xticks([i + 1.5 * bar_width for i in index], services)
    plt.legend(loc='upper left', ncol=2)

    plt.savefig(f'./images/request_time_services.png', dpi=300)
    plt.clf()

def request_time_services():
    services = ['EC2', 'ECS', 'LAMBDA']

    XML=[412.94, 418.02, 494.15]
    JSON=[387.60, 389.40, 489.56]
    MSGPACK=[367.62, 365.95, 483.56]
    KRYO=[332.14, 319.76, 435.04]

    bar_width = 0.2
    index = range(len(services))

    plt.bar(index, XML, bar_width, color='0.1', label='XML') 
    plt.bar([i + bar_width for i in index], JSON, bar_width, color='0.3', label='JSON') 
    plt.bar([i + 2 * bar_width for i in index], MSGPACK, bar_width, color='0.6', label='MSGPACK') 
    plt.bar([i + 3 * bar_width for i in index], KRYO, bar_width, color='0.8', label='KRYO') 

    plt.gca().spines['top'].set_visible(False)
    plt.gca().spines['right'].set_visible(False)

    plt.gca().tick_params(axis='x', colors='k')
    plt.gca().tick_params(axis='y', colors='k')

    plt.xlabel('Serviço')
    plt.ylabel('Tempo médio total da requisição (ms)')
    plt.xticks([i + 1.5 * bar_width for i in index], services)
    plt.legend(loc='upper left', ncol=2)

    plt.savefig(f'./images/request_time_services.png', dpi=300)
    plt.clf()

def request_time_format():
    services = ['STRUCT', 'STRING', 'CHAR', 'DOUBLE', 'INTEGER', 'BOOLEAN']

    XML=[772.44, 406.11, 370.20, 368.97, 367.17, 365.31]
    JSON=[742.91, 402.01, 345.96, 350.96, 344.29, 345.79]
    MSGPACK=[683.52, 403.98, 352.61, 348.22, 323.84, 322.11]
    KRYO=[416.72, 349.59, 348.72, 346.69, 346.11, 346.05]

    bar_width = 0.2
    index = range(len(services))

    plt.bar(index, XML, bar_width, color='0.1', label='XML') 
    plt.bar([i + bar_width for i in index], JSON, bar_width, color='0.3', label='JSON') 
    plt.bar([i + 2 * bar_width for i in index], MSGPACK, bar_width, color='0.6', label='MSGPACK') 
    plt.bar([i + 3 * bar_width for i in index], KRYO, bar_width, color='0.8', label='KRYO') 

    plt.gca().spines['top'].set_visible(False)
    plt.gca().spines['right'].set_visible(False)

    plt.gca().tick_params(axis='x', colors='k')
    plt.gca().tick_params(axis='y', colors='k')

    plt.xlabel('Formato')
    plt.ylabel('Tempo médio total da requisição')
    plt.xticks([i + 1.5 * bar_width for i in index], services)
    plt.legend(loc='upper right')

    plt.savefig(f'./images/request_time_format.png', dpi=300)
    plt.clf()

serialization_deserialization_time()
bytes_size_services()
request_time_services()
request_time_format()