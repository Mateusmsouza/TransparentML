from pydantic import BaseModel


class Metric(BaseModel):
    name: str
    value: float
    step: int


class Experiment(BaseModel):
    name: str
    description: str
    tags: list[str]
    metrics: list[Metric]
