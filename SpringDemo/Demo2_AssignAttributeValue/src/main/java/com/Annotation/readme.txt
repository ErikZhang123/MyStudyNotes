基于注解的DI（dependency inject 依赖注入）
主要包含以下注解：
@Component （功能不明确的对象）
@Repository （DAO对象）
@Service    （service对象）
@Controller （Controller对象）
以上四个注解是为给不同的对象进行分层，
@Value
@Autowired
@Resource
后面三个是为了给对象的属性进行赋值。