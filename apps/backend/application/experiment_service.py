from typing import Optional
from domain.entities import Experiment
from domain.repositories.experiment_repository_interface import ExperimentRepositoryInterface


class ExperimentService:

    def __init__(self, repository: ExperimentRepositoryInterface):
        self.repository = repository

    def create(self, experiment: Experiment) -> str:
        return self.repository.save(experiment=experiment)

    def get_experiment(self, experiment_id: str) -> Optional[Experiment]:
        return self.repository.find_by_id(experiment_id=experiment_id)
