from typing import Optional
from domain.entities import Metric
from domain.repositories.metric_repositoiry import MetricRepositoryInterface


class ExperimentService:

    def __init__(self, repository: MetricRepositoryInterface):
        self.repository = repository

    def create(self, experiment: Metric, experiment_uuid: str) -> str:
        return self.repository.save(metric=Metric, experiment_uuid=experiment_uuid)
