from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    mongodb_host: str
    mongodb_user: str
    mongodb_passwd: str


settings = Settings()
