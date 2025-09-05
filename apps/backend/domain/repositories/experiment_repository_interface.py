from typing import Protocol, Optional
from domain.entities import Experiment


class ExperimentRepositoryInterface(Protocol):

    def save(self, experiment: Experiment) -> str: ...
    def find_by_id(self, id: str) -> Optional[Experiment]: ...
