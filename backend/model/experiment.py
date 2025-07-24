from datetime import datetime

from beanie import Document

class Experiment(Document):

    name: str
    description: str
    #TODO add tags list
    created_at: datetime
