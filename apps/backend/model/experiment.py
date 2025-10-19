from datetime import datetime

from beanie import Document


class Experiment(Document):

    name: str
    description: str
    tags: list[str]
    created_at: datetime
