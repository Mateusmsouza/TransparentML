from beanie import Document, PydanticObjectId
from pydantic import Field


class MetricDocument(Document):
    id: PydanticObjectId = Field(default_factory=PydanticObjectId, alias="_id")
    name: str
    value: float
    step: int

    class Settings:
        name = "metrics"


class ExperimentDocument(Document):
    id: PydanticObjectId = Field(default_factory=PydanticObjectId, alias="_id")
    name: str
    description: str
    tags: list[str] = Field(default_factory=list)
    metrics: list[MetricDocument] = Field(default_factory=list)

    class Settings:
        name = "experiments"
