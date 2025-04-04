# TransparentML

```
transparentml/
├── domain/
│   ├── model/              # entidades: Experiment, Metric
│   └── repository/         # interfaces (ports) de persistência
├── application/
│   └── usecase/            # casos de uso: CriarExperimento, SalvarMetrica
├── adapters/
│   ├── in/                 # entrada: controllers REST
│   └── out/                # saída: banco de dados (implementações dos repositórios)
├── infrastructure/         # configs do Quarkus, persistência
└── shared/                 # DTOs, utilitários
```
