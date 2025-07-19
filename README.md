Finalidade	                  Comando
Criar                         contêiner PostgreSQL	docker run --name nap01dev -e POSTGRES_DB=produto_db -e POSTGRES_USER=aula -e POSTGRES_PASSWORD=senha -p 5428:5432 -d postgres
Listar                        contêineres	docker ps -a
Iniciar / parar	              docker start nap01dev
Acessar psql	                docker exec -it nap01dev psql -U aula -d produto_db
Remover contêiner  	          docker rm -f nap01dev
Limpar imagens órfãs	        docker image prune -a



