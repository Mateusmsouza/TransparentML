from beanie import Document


class MetricDocument(Document):
    id: str
    name: str
    value: str
    step: int

    class Settings:
        name = "metrics"


class ExperimentDocument(Document):
    name: str
    description: str
    tags: list[str]
    metrics: list[MetricDocument]

    class Settings:
        name = "experiments"
