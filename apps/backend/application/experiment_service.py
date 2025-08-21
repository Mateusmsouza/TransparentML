from typing import Protocol, Optional
from domain.entities import Experiment


class ExperimentRepositoryInterface(Protocol):

    def save(self, experiment: Experiment) -> str: ...
    def find_by_id(self, id: str) -> Optional[Experiment]: ...


class ExperimentService:

    def __init__(self, repository: ExperimentRepositoryInterface):
        self.repository = repository

    def create(self, experiment: Experiment) -> str:
        return self.repository.save(experiment=experiment)

    def get_experiment(self, experiment_id: str) -> Optional[Experiment]:
        return self.repository.find_by_id(experiment_id=experiment_id)
