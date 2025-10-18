from typing import Protocol, Optional
from domain.entities import Metric


class MetricRepositoryInterface(Protocol):

    def save(self, metric: Metric, experiment_uuid: str) -> str: ...
